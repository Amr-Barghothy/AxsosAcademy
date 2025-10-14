from django.db import models
import re


# Create your models here.

class UserManager(models.Manager):
    def reg_validator(self, post_data):
        errors = {}
        if post_data['firstname'] == '':
            errors['firstname'] = 'firstname is required'
        elif len(post_data['firstname']) < 2:
            errors['firstname'] = 'firstname should be at least 2 characters'
        if post_data['lastname'] == '':
            errors['lastname'] = 'lastname is required'
        elif len(post_data['lastname']) < 2:
            errors['lastname'] = 'lastname should be at least 2 characters'
        if post_data['reg_email'] == '':
            errors['email'] = 'email is required'
        if post_data['reg_password'] == '':
            errors['password'] = 'password is required'

        pattern = re.compile(r'^[a-z.A-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$')
        if not pattern.match(post_data['reg_email']):
            errors['invalid_email'] = 'email is invalid'
        if len(post_data['reg_password']) < 8 and post_data['reg_password'] != '':
            errors['small_password'] = 'small password should be at least 8 characters'
        if post_data['reg_password'] != post_data['confirm_pw']:
            errors['password_mismatch'] = 'password mismatch'
        return errors

    def email_validator(self, post_data):
        errors = {}
        if post_data['email'] == '':
            errors['login_email'] = 'email is required'
        if post_data['password'] == '':
            errors['login_password'] = 'password is required'
        pattern = re.compile(r'^[a-z.A-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$')
        if not pattern.match(post_data['email']):
            errors['invalid_email'] = 'email is invalid'
        elif not User.objects.filter(email=post_data['email']).exists():
            errors['email_not_found'] = 'Email does not exist'

        return errors


class User(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    email = models.CharField(max_length=45)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()


class BookManager(models.Manager):
    def book_validator(self, post_data):
        errors = {}
        if post_data['title'] == '':
            errors['title'] = 'title is required'
        if post_data['desc'] == '':
            errors['description'] = 'description is required'
        if post_data['desc'] != '' and len(post_data['desc']) < 5:
            errors['description_len'] = 'description should be at least 5 characters'
        return errors

    def update_book_validator(self,post_data):
        errors = {}
        if post_data['desc'] == '':
            errors['description'] = "description shouldn't be empty to update "
        if post_data['desc'] != '' and len(post_data['desc']) < 5:
            errors['description_len'] = 'description should be at least 5 characters'
        return errors

class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField()
    uploaded_by = models.ForeignKey(User, related_name='books', on_delete=models.CASCADE)
    favorites = models.ManyToManyField(User, related_name='favorites')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = BookManager()

def create_user(firstname, lastname, email, password):
    return User.objects.create(first_name=firstname, last_name=lastname, email=email, password=password)


def get_user_by_email(user_email):
    return User.objects.filter(email=user_email)


def get_user_by_id(user_id):
    return User.objects.get(id=user_id)


def create_book(title, desc, uploaded_by):
    return Book.objects.create(title=title, desc=desc, uploaded_by=uploaded_by)

def get_all_books():
    return Book.objects.all()

def get_book_by_id(book_id):
    return Book.objects.get(id=book_id)

def check_if_favorite(user_id,book_id):
    return Book.objects.filter(id=book_id, favorites=user_id).exists()


def make_favorite(user_id, book_id):
    book = get_book_by_id(book_id)
    user = get_user_by_id(user_id)
    book.favorites.add(user)


def rem_favorite(user_id, book_id):
    book = get_book_by_id(book_id)
    user = get_user_by_id(user_id)
    book.favorites.remove(user)


def delete_book( book_id):
    return get_book_by_id(book_id).delete()


def update_book( book_id,desc):
    book = get_book_by_id(book_id)
    book.desc = desc
    book.save()
    return book