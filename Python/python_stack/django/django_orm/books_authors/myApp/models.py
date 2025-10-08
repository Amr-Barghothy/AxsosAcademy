from django.db import models

# Create your models here.

class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Author(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    notes = models.TextField()
    books = models.ManyToManyField(Book, related_name='authors')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

def get_all_authors():
    return Author.objects.all()

def get_all_books():
    return Book.objects.all()

def get_book_by_id(book_id):
    return Book.objects.get(id=book_id)

def get_author_by_id(author_id):
    return Author.objects.get(id=author_id)

def create_author(first_name, last_name, notes):
    return Author.objects.create(first_name=first_name, last_name=last_name, notes=notes)

def create_book(title, desc):
    return Book.objects.create(title=title, desc=desc)

def connect_author(author,book):
    return author.books.add(book)

def connect_book(author,book):
    return book.authors.add(author)