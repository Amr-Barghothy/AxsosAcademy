from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *
import bcrypt


# Create your views here.


def index(request):
    if 'id' in request.session:
        del request.session['id']
    messages.success(request, '')
    return render(request, 'index.html')


def register(request):
    if 'id' in request.session:
        del request.session['id']
    errors = User.objects.reg_validator(request.POST)
    for key, value in errors.items():
        messages.error(request, value)
    if len(errors) > 0:
        return redirect('/')
    else:
        firstname = request.POST['firstname']
        lastname = request.POST['lastname']
        email = request.POST['reg_email']
        password = request.POST['reg_password']
        hashed_pw = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
        user = create_user(firstname, lastname, email, hashed_pw)
        request.session['id'] = ''
        request.session['id'] = user.id
        return redirect(success)


def login(request):
    if 'id' in request.session:
        del request.session['id']
    errors = User.objects.email_validator(request.POST)
    for key, value in errors.items():
        messages.error(request, value)
    if len(errors) > 0:
        return redirect('/')
    else:
        email = request.POST['email']
        password = request.POST['password']
        user = get_user_by_email(email)
        exists = bcrypt.checkpw(password.encode(), user[0].password.encode())
        print(exists)
        request.session['id'] = ''
        if exists:
            request.session['id'] = user[0].id
            return redirect(success)
        else:
            messages.error(request, 'Password does not match')
            return redirect('/')


def success(request):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    return redirect('/books')


def logout(request):
    del request.session['id']
    return redirect('/')


# Books Section

def books(request):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    books = get_all_books()
    user = get_user_by_id(request.session['id'])
    for book in books:
        book.is_user_favorite = user in book.favorites.all()

    context = {
        'books': books,
        'user': get_user_by_id(request.session['id']),
    }
    if 'id' in request.session:
        return render(request, 'books.html', context)
    return redirect('/')


def add_book(request):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    errors = Book.objects.book_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/books')
    else:
        title = request.POST['title']
        description = request.POST['desc']
        user = get_user_by_id(request.session['id'])
        book = create_book(title, description, user)
        make_favorite(user.id,book.id)
        return redirect('/books')


def detail_book(request, book_id):
    if 'id' in request.session:
        user = get_user_by_id(request.session['id'])
        book = get_book_by_id(book_id)
        context = {
            'book': get_book_by_id(book_id),
            'is_favorite': check_if_favorite(request.session['id'],book_id),
            'user': get_user_by_id(request.session['id']),
            'is_author': user.id == book.uploaded_by.id,
        }
        return render(request, 'details.html', context)
    messages.error(request, 'Please login or register')
    return redirect('/')


def add_favorite(request, book_id):
    if 'id' in request.session:
        make_favorite(request.session['id'], book_id)
        return redirect('/books/' + book_id)
    messages.error(request, 'Please login or register')
    return redirect('/')


def remove_favorite(request, book_id):
    if 'id' in request.session:
        rem_favorite(request.session['id'], book_id)
        return redirect('/books/' + book_id)
    messages.error(request, 'Please login or register')
    return redirect('/')


def delete_a_book(request, book_id):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    book = get_book_by_id(book_id)
    user_id = request.session['id']
    if user_id == book.uploaded_by.id:
        delete_book(book_id)
        return redirect('/books')
    else:
        messages.error(request, 'You do not have permission to delete this book')
        return redirect('/books')


def update_a_book(request, book_id):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    book = get_book_by_id(book_id)
    user_id = request.session['id']
    if user_id == book.uploaded_by.id:
        errors = Book.objects.update_book_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
        desc = request.POST['desc']
        update_book(book_id, desc)
        return redirect('/books/' + book_id)
    else:
        messages.error(request, 'You do not have permission to Update this book')
        return redirect('/books')
