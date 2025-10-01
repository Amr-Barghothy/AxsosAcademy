from django.http import JsonResponse
from django.shortcuts import render, redirect, HttpResponse
from django.template.defaulttags import lorem


def root( request ):
    return redirect("/blogs")


def index( request ):
    return render(request, 'blogs.html')


def new( request ):
    return HttpResponse("placeholder to display a new form to create a new blog")


def create( request ):
    return redirect("/")


def show( request, number ):
    return HttpResponse(f"placeholder to display blog number {number}")


def edit( request, number ):
    return HttpResponse(f"placeholder to edit blog {number}")


def destroy( request ,number ):
    return redirect("/blogs")


def json( request ):
    context = { "title": "My First Blog",
                "content": "Lorem ipsum dolor sit amet, consetetur sadipscing eli" }
    return JsonResponse({ "response": context, "status": True })
