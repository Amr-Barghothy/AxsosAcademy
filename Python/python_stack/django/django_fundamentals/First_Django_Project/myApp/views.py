from django.http import JsonResponse
from django.shortcuts import render, redirect, HttpResponse
from django.template.defaulttags import lorem


def root( request ):
    return redirect("/blogs")


def index( request ):
    return render(request, 'blogs.html')


def new( request ):
    return render(request, 'new.html')


def create( request ):
    return redirect("/")


def show( request, number ):
    s = { "num": number }
    print(s)
    return render(request, 'show.html', s)


def edit( request, number ):
    s = { "num": number }
    return render(request, 'edit.html', s)


def destroy( request ):
    return redirect("/blogs")


def json( request ):
    context = { "title": "My First Blog",
                "content": "Lorem ipsum dolor sit amet, consetetur sadipscing eli" }
    return JsonResponse({"response": context, "status": True})