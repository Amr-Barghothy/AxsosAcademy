from django.shortcuts import render,redirect
from .models import *
# Create your views here.

def index(request):
    context = {
        'books': get_all_books()
    }
    return render(request, 'index.html',context)

def books(request,book_id):
    curr_book = get_book_by_id(book_id)
    context = {
        'curr_book': curr_book,
        'authors': get_all_authors()
    }
    return render(request, 'book_details.html',context)

def add_a_book(request):
    title = request.POST['title']
    desc = request.POST['desc']
    create_book(title,desc)
    return redirect('/')

def add_author_to_book(request):
    boo_id = request.POST['book_id']
    curr_book = get_book_by_id(request.POST['book_id'])
    curr_author = get_author_by_id(request.POST['author'])
    connect_book(curr_author,curr_book)
    return redirect(f'/books/{boo_id}')


def authors(request):
    context = {
        'authors': get_all_authors()
    }
    return render(request, 'authors.html', context)

def author_details(request,author_id):
    curr_author = get_author_by_id(author_id)
    context = {
        'curr_author': curr_author,
        'books': get_all_books()
    }
    return render(request, 'author_details.html', context)

def add_an_author(request):
    first_name = request.POST['fname']
    last_name = request.POST['lname']
    notes = request.POST['notes']
    create_author(first_name,last_name,notes)
    return redirect('/author')

def add_book_to_author(request):
    auth_id = request.POST['author_id']
    curr_book = get_book_by_id(request.POST['book'])
    curr_author = get_author_by_id(auth_id)
    connect_author(curr_author,curr_book)
    return redirect(f'/authors/{auth_id}')