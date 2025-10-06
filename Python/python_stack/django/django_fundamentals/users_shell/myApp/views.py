from django.shortcuts import render,redirect
from .models import User


def index(request):
    all_users = User.objects.all()
    print(all_users)
    return render(request, 'index.html', {'all_users': all_users})


def add_user(request):
    firstname = request.POST['first_name']
    lastname = request.POST['last_name']
    email = request.POST['email']
    age = request.POST['age']
    User.objects.create(first_name=firstname, last_name=lastname, email_address=email, age=age)
    return redirect('/')