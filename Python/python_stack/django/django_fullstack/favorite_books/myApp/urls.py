from django.urls import path
from . import views

urlpatterns = [
    path('',views.index),
    path('login',views.login),
    path('register',views.register),
    path('success',views.success),
    path('logout',views.logout),
    path('books',views.books),
    path('add_book',views.add_book),
    path('books/<book_id>' ,views.detail_book),
    path('add_fav/<book_id>',views.add_favorite),
    path('remove_fav/<book_id>',views.remove_favorite),
    path('delete_book/<book_id>',views.delete_a_book),
    path('update_book/<book_id>',views.update_a_book),

]