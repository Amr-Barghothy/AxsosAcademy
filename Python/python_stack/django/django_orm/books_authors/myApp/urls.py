from django.urls import path
from . import views

urlpatterns = [
    path('',views.index),
    path('books/<int:book_id>',views.books),
    path('add_a_book',views.add_a_book),
    path('add_book_to_author',views.add_book_to_author),
    path('author',views.authors),
    path('authors/<int:author_id>',views.author_details),
    path('add_an_author',views.add_an_author),
    path('add_author_to_book',views.add_author_to_book),
]