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
    firstname = models.CharField(max_length=50)
    lastname = models.CharField(max_length=50)
    email = models.EmailField()
    password = models.CharField(max_length=50)
    create_at = models.DateTimeField(auto_now_add=True)
    update_at = models.DateTimeField(auto_now=True)
    objects = UserManager()


def create_user(firstname, lastname, email, password):
    return User.objects.create(firstname=firstname, lastname=lastname, email=email, password=password)


def get_user_by_email(user_email):
    return User.objects.filter(email=user_email)

def get_user_by_id(user_id):
    return User.objects.filter(id=user_id)