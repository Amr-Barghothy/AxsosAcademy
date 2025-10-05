from django.shortcuts import render, redirect
import random


# Create your views here.

def index( request ):
    if not "number" in request.session:
        request.session["number"] = 0
        num = random.randint(1, 100)
        request.session["number"] = num

    return render(request, 'index.html')


def guess( request ):
    if not "guessed" in request.session:
        request.session["guessed"] = 0
    request.session["guessed"] = int(request.POST["number"])
    return redirect("/")

def reset( request ):
    del request.session["guessed"]
    del request.session["number"]
    return redirect("/")