from django.contrib import messages
from django.shortcuts import render, redirect
from .models import *


# Create your views here.

def index(request):
    context = {
        "shows": get_all_show()
    }
    return render(request, 'display_shows.html', context)


def add_show(request):
    return render(request, 'add_shows.html')


def add_new_show(request):
    errors = Shows.objects.validate_show(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(add_show)
    else:
        title = request.POST['title']
        network = request.POST['network']
        release_date = request.POST['release_date']
        desc = request.POST['desc']
        new_show = add_a_show(title, network, release_date, desc)
        id = new_show.id

    return redirect(f'shows/{id}')


def display_show(request, id):
    show = get_a_show(id)
    context = {
        'show': show
    }
    return render(request, 'show.html', context)


def show_edit(request, id):
    context = {
        'id': id
    }
    return render(request, 'edit_shows.html', context)


def show_update(request):
    id = request.POST['hidden']
    context = {
        'id': id
    }
    errors = Shows.objects.validate_show(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect( 'show_edit/'+id)
    else:
        title = request.POST['title']
        network = request.POST['network']
        release_date = request.POST['release_date']
        desc = request.POST['desc']
        update_a_show(id, title, network, release_date, desc)
        return redirect(f'shows/{id}')


def delete_show(request, id):
    delete_a_show(int(id))
    return redirect('/')
