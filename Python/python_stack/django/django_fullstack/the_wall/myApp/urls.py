from django.urls import path
from . import views

urlpatterns = [
    path('',views.index),
    path('post_message',views.post_message),
    path('post_comment/<int:msg_id>',views.post_comment),
    path('delete/<comment_id>',views.delete_a_comment),
]

