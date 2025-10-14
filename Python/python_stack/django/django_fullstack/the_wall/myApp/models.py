from django.db import models
from login.models import *

class Message(models.Model):
    message = models.TextField()
    user = models.ForeignKey(User,related_name='users',on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Comment(models.Model):
    comment = models.TextField()
    messages = models.ForeignKey(Message,related_name='comments',on_delete=models.CASCADE)
    users = models.ForeignKey(User,related_name='comment_users',on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def create_message(message,user):
    return Message.objects.create(message=message,user=user)

def create_comment(comment,message,user):
    return Comment.objects.create(comment=comment,messages=message,users=user)

def get_all_comments():
    return Comment.objects.all().order_by('created_at')

def get_all_messages():
    return Message.objects.all().order_by('-created_at')

def get_message_by_id(message_id):
    return Message.objects.get(id=message_id)

def delete_comment(comment_id):
    return Comment.objects.get(id=comment_id).delete()