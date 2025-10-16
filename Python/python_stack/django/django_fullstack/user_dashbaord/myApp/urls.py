from django.urls import path
from . import views

urlpatterns = [
    path('',views.index),
    path('signin',views.signin),
    path('login',views.login),
    path('signup',views.signup),
    path('register',views.register),
    path('logout',views.logout),
    path('dashboard',views.dashboard),
    path('dashboard/admin',views.dashboard_admin),
    path('users/new',views.add_user),
    path('add/new/user',views.add_a_user),
    path('users/show/<user_id>',views.show_user),
    path('post_message/<user_id>',views.post_message),
    path('post_comment/<user_id>/<msg_id>',views.post_comment),
    path('delete/<user_id>/<comment_id>',views.delete_a_comment),
    path('users/edit',views.edit_user),
    path('update_user/<user_id>',views.update_a_user),
    path('update_a_password/<user_id>',views.update_a_password),
    path('update_description/<user_id>',views.update_a_description),
    path('users/edit/<user_id>',views.edit_user_admin),
    path("delete_user/<user_id>",views.delete_a_user),
]