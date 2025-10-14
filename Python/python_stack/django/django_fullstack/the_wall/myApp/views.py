from django.shortcuts import render, redirect
from .models import *
from login.models import *


# Create your views here.

def index(request):
    if "id" not in request.session:
        return redirect('/')
    context = {
        'messages': get_all_messages()
    }
    return render(request, 'wall.html', context)


def post_message(request):
    if "id" not in request.session:
        return redirect('/')
    user_id = request.session.get('id')
    msg = request.POST['msg']
    user = get_user_by_id(user_id)
    create_message(msg, user[0])
    return redirect('/wall')


def post_comment(request, msg_id):
    if "id" not in request.session:
        return redirect('/')
    user_id = request.session.get('id')
    comment = request.POST['comment']
    user = get_user_by_id(user_id)
    msg = get_message_by_id(msg_id)
    create_comment(comment, msg, user[0])
    return redirect('/wall')

def delete_a_comment(request, comment_id):
    if "id" not in request.session:
        return redirect('/')
    delete_comment(comment_id)
    return redirect('/wall')
