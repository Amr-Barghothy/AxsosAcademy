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
        if post_data['email'] == '':
            errors['email'] = 'email is required'
        if post_data['password'] == '':
            errors['password'] = 'password is required'

        pattern = re.compile(r'^[a-z.A-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$')
        if not pattern.match(post_data['email']):
            errors['invalid_email'] = 'email is invalid'
        if len(post_data['password']) < 8 and post_data['password'] != '':
            errors['small_password'] = 'password should be at least 8 characters'
        if post_data['password'] != post_data['confirm-pw']:
            errors['password_mismatch'] = 'password mismatch'
        return errors

    def email_validator(self, post_data):
        errors = {}
        if post_data['email'] == '':
            errors['login_email'] = 'email is required'
        user = User.objects.filter(email=post_data['email'])
        if post_data['password'] == '':
            errors['login_password'] = 'password is required'
        pattern = re.compile(r'^[a-z.A-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$')
        if not pattern.match(post_data['email']):
            errors['invalid_email'] = 'email is invalid'
        elif len(user) <= 0:
            errors['email_not_found'] = 'Email does not exist'
        return errors

    def password_validator(self, post_data):
        errors = {}
        if post_data['password'] == '':
            errors['password'] = 'password is required'
        if len(post_data['password']) < 8 and post_data['password'] != '':
            errors['small_password'] = 'small password should be at least 8 characters'
        if post_data['password'] != post_data['confirm-pw']:
            errors['password_mismatch'] = 'password mismatch'

        return errors


class User(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    email = models.CharField(max_length=45)
    password = models.CharField(max_length=255)
    role = models.CharField(max_length=45)
    desc = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()


class Message(models.Model):
    message = models.TextField()
    user = models.ForeignKey(User, related_name='messages', on_delete=models.CASCADE)
    wrote_by = models.ForeignKey(User, related_name='wrote_by', on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


class Comment(models.Model):
    comment = models.TextField()
    messages = models.ForeignKey(Message, related_name='comments', on_delete=models.CASCADE)
    users = models.ForeignKey(User, related_name='comment_users', on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def create_user(firstname, lastname, email, password, role):
    return User.objects.create(first_name=firstname, last_name=lastname, email=email, password=password, role=role)


def get_user_by_email(user_email):
    return User.objects.filter(email=user_email)


def get_user_by_id(user_id):
    return User.objects.filter(id=user_id)


def get_all_users():
    return User.objects.all()


def create_message(message, user, wrote_by):
    return Message.objects.create(message=message, user=user, wrote_by=wrote_by)


def create_comment(comment, message, user):
    return Comment.objects.create(comment=comment, messages=message, users=user)


def get_all_comments():
    return Comment.objects.all().order_by('created_at')


def get_comment_by_id(comment_id):
    return Comment.objects.get(id=comment_id)


def get_all_messages():
    return Message.objects.all().order_by('-created_at')


def get_message_by_id(message_id):
    return Message.objects.get(id=message_id)


def delete_comment(comment_id):
    return Comment.objects.get(id=comment_id).delete()


def update_user(user_id, firstname, lastname, email, role="User"):
    user = User.objects.get(id=user_id)
    user.first_name = firstname
    user.last_name = lastname
    user.email = email
    user.role = role
    user.save()
    print(user)
    return user


def update_password(user_id, password):
    user = User.objects.get(id=user_id)
    user.password = password
    user.save()
    return user

def update_description(user_id, description):
    user = User.objects.get(id=user_id)
    user.desc = description
    user.save()
    return user

def delete_user(user_id):
    return User.objects.get(id=user_id).delete()