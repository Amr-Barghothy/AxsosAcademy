from django.shortcuts import render,redirect
from .models import create_dojo,create_ninjas,get_dojo,get_all_dojos,delete_dojo
# Create your views here.

def index(request):
    dojos = get_all_dojos()
    context = {
        'dojos': dojos
    }
    return render(request, 'index.html', context)

def add_dojo(request):
    name = request.POST['name']
    city = request.POST['city']
    state = request.POST['state']
    temp = create_dojo(name,city,state)
    print(temp)
    return redirect('/')


def add_ninjas(request):
    first_name = request.POST['fname']
    last_name = request.POST['lname']
    dojo_id = request.POST['dojo_select']
    dojo = get_dojo(dojo_id)
    create_ninjas(first_name,last_name,dojo)
    return redirect('/')

def delete_a_dojo(request):
    dojo_id = request.POST['delete_dojo']
    dojo = delete_dojo(dojo_id)
    return redirect('/')
