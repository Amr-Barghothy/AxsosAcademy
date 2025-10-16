from django.shortcuts import render, redirect
from .models import *
from django.contrib import messages
import bcrypt


# Create your views here.

def index(request):
    return render(request, 'index.html')


def signup(request):
    return render(request, 'signup.html')


def register(request):
    if request.method != 'POST':
        return redirect('/signup')
    if 'id' in request.session:
        del request.session['id']
    errors = User.objects.reg_validator(request.POST)
    for key, value in errors.items():
        messages.error(request, value)
    if len(errors) > 0:
        return redirect('/register')
    else:
        firstname = request.POST['firstname']
        lastname = request.POST['lastname']
        email = request.POST['email']
        password = request.POST['password']
        users = get_all_users()
        role = "User"
        if len(users) == 0:
            role = "Admin"
        hashed_pw = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
        user_id = create_user(firstname, lastname, email, hashed_pw, role)
        request.session['id'] = ''
        request.session['id'] = user_id.id
        return redirect(dashboard)


def signin(request):
    return render(request, 'signin.html')


def login(request):
    if 'id' in request.session:
        del request.session['id']
    errors = User.objects.email_validator(request.POST)
    for key, value in errors.items():
        messages.error(request, value)
    if len(errors) > 0:
        return redirect('/signin')
    else:
        email = request.POST['email']
        password = request.POST['password']
        user = get_user_by_email(email)
        exists = bcrypt.checkpw(password.encode(), user[0].password.encode())
        request.session['id'] = ''
        if exists:
            request.session['id'] = user[0].id
            if user[0].role == 'User':
                return redirect(dashboard)
            else:
                return redirect(dashboard_admin)
        else:
            messages.error(request, 'Password does not match')
            return redirect('/signin')


def dashboard(request):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    users = get_all_users()
    context = {'users': users}
    return render(request, 'dashboard.html', context)


def dashboard_admin(request):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    user = get_user_by_id(request.session['id'])
    if user[0].role == 'User':
        messages.error(request, 'You can\'t access this page')
        return redirect('/dashboard')
    users = get_all_users()
    context = {'users': users}
    return render(request, 'dashboard_admin.html', context)


def add_user(request):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    user = get_user_by_id(request.session['id'])
    if user[0].role == 'User':
        messages.error(request, 'You can\'t access this page')
        return redirect('/dashboard')
    return render(request, 'new_user.html')


def add_a_user(request):
    if request.method != 'POST':
        return redirect('/signin')
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    user = get_user_by_id(request.session['id'])
    if user[0].role == 'User':
        messages.error(request, 'You can\'t access this page')
        return redirect('/dashboard')
    errors = User.objects.reg_validator(request.POST)
    for key, value in errors.items():
        messages.error(request, value)
    if len(errors) > 0:
        return redirect('/users/new')
    else:
        firstname = request.POST['firstname']
        lastname = request.POST['lastname']
        email = request.POST['email']
        password = request.POST['password']
        role = "User"
        hashed_pw = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
        create_user(firstname, lastname, email, hashed_pw, role)
        return redirect(add_user)


def show_user(request, user_id):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    context = {
        'messages': get_all_messages(),
        'user': get_user_by_id(user_id)[0],
        'admin' : get_user_by_id(request.session['id'])[0],
    }
    return render(request, 'show_user.html', context)


def post_message(request, user_id):
    if request.method != 'POST':
        return redirect('/dashboard')
    if "id" not in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    msg = request.POST['msg']
    user = get_user_by_id(user_id)
    wrote_by = get_user_by_id(request.session['id'])
    create_message(msg, user[0], wrote_by[0])
    return redirect('/users/show/' + user_id)


def post_comment(request, user_id, msg_id):
    if request.method != 'POST':
        return redirect('/dashboard')
    if "id" not in request.session:
        return redirect('/')
    comment = request.POST['comment']
    user = get_user_by_id(request.session['id'])
    msg = get_message_by_id(msg_id)
    create_comment(comment, msg, user[0])
    return redirect('/users/show/' + user_id)


def delete_a_comment(request, user_id, comment_id):
    if "id" not in request.session:
        return redirect('/')
    comment = get_comment_by_id(comment_id)
    print(request.session['id'])
    print(comment.users.id)
    if request.session['id'] != comment.users.id:
        return redirect('/users/show/' + user_id)
    delete_comment(comment_id)
    return redirect('/users/show/' + user_id)


def edit_user(request):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    return render(request, 'edit_profile.html', {'user': get_user_by_id(request.session['id'])[0]})


def update_a_user(request, user_id):
    if request.method != 'POST':
        return redirect('/dashboard')
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')

    user = get_user_by_id(request.session['id'])
    if user[0].role == 'User' and int(user_id) != user[0].id:
        messages.error(request, 'You don\'t have permission')
        return redirect('/users/edit')

    errors = User.objects.email_validator(request.POST)
    for key, value in errors.items():
        messages.error(request, value)
    if len(errors) > 0:
        if user[0].role == 'User':
            return redirect('/users/edit')
        else:
            return redirect('/users/edit/' + user_id)
    firstname = request.POST['firstname']
    lastname = request.POST['lastname']
    email = request.POST['email']
    update_user(user_id, firstname, lastname, email)
    if user[0].role == 'Admin':
        return redirect('/users/edit/' + user_id)
    else:
        messages.success(request, 'Updated Successfully')
        return redirect('/users/edit')


def update_a_password(request, user_id):
    if request.method != 'POST':
        return redirect('/dashboard')
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    user = get_user_by_id(request.session['id'])
    if user[0].role == 'User' and int(user_id) != user[0].id:
        messages.error(request, 'You don\'t have permission')
        return redirect('/users/edit')

    errors = User.objects.password_validator(request.POST)
    for key, value in errors.items():
        messages.error(request, value)
    if len(errors) > 0:
        if user[0].role == 'User':
            return redirect('/users/edit')
        else:
            return redirect('/users/edit/' + user_id)
    password = request.POST['password']
    print(password)
    password_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
    update_password(user_id, password_hash)
    if user[0].role == 'Admin':
        return redirect('/users/edit/' + user_id)
    else:
        messages.success(request, 'Updated Successfully')
        return redirect('/users/edit')


def update_a_description(request, user_id):
    if request.method != 'POST':
        return redirect('/dashboard')
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    user = get_user_by_id(request.session['id'])
    if user[0].role == 'User' and int(user_id) != user[0].id:
        messages.error(request, 'You don\'t have permission')
        return redirect('/users/edit')
    description = request.POST['desc']
    print(description)
    update_description(user_id, description)
    if user[0].role == 'Admin':
        return redirect('/users/edit/' + user_id)
    else:
        messages.success(request, 'Updated Successfully')
        return redirect('/users/edit')


def edit_user_admin(request, user_id):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    return render(request, 'edit_profile_admin.html', {'user': get_user_by_id(user_id)[0]})


def delete_a_user(request, user_id):
    if not 'id' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    user = get_user_by_id(request.session['id'])
    if user[0].role == 'User' and int(user_id) != user[0].id:
        messages.error(request, 'You don\'t have permission')
        return redirect('/users/edit')
    delete_user(user_id)
    return redirect('/dashboard/admin')

def logout(request):
    del request.session['id']
    return redirect('/')
