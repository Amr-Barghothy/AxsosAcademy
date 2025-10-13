from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *
import bcrypt


# Create your views here.


def index(request):
    if 'name' in request.session:
        del request.session['name']
    messages.success(request, '')
    return render(request, 'index.html')


def register(request):
    if 'name' in request.session:
        del request.session['name']
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
        create_user(firstname, lastname, email, hashed_pw)
        request.session['name'] = ''
        request.session['name'] = firstname
        messages.success(request, 'Successfully registered (or logged in)')
        return redirect(success)


def login(request):
    if 'name' in request.session:
        del request.session['name']
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
        request.session['name'] = ''
        if exists:
            messages.success(request, 'Successfully registered (or logged in)')
            request.session['name'] = user[0].firstname
            return redirect(success)
        else:
            messages.error(request, 'Password does not match')
            return redirect('/')


def success(request):
    if not 'name' in request.session:
        messages.error(request, 'Please login or register')
        return redirect('/')
    return render(request, 'success.html')


def logout(request):
    del request.session['name']
    return redirect('/')