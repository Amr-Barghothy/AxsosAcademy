from django.shortcuts import render,redirect
from .models import *
from django.contrib import messages
# Create your views here.


def index(request):
    context = {
        'courses': get_all_courses()
    }
    return render(request, 'index.html',context)


def add_course(request):
    errors = Course.objects.validate_course(request.POST)
    for error in errors.values():
        messages.error(request, error)
    if len(errors) > 0:
        return redirect("/")
    else:
        name = request.POST['name']
        description = request.POST['description']
        desc = create_a_description(description)
        create_a_course(name, desc)
        return redirect("/")


def destroy(request,course_id):
    context = {
        'courses': get_a_course(course_id)
    }
    return render(request, 'remove.html',context)

def delete(request,course_id):
    delete_a_course(course_id)
    return redirect("/")