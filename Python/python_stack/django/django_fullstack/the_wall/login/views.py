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
        user_id = create_user(firstname, lastname, email, hashed_pw)
        request.session['id'] = ''
        request.session['id'] = user_id.id
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
    return redirect('/wall')


def logout(request):
    del request.session['id']
    return redirect('/')