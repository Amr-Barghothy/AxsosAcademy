from django.db import models


# Create your models here.

class Shows(models.Model):
    title = models.CharField(max_length=100)
    network = models.CharField(max_length=100)
    release_date = models.DateField()
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def add_a_show(title, network, release_date, description):
    return Shows.objects.create(title=title, network=network, release_date=release_date, description=description)


def update_a_show(id, title, network, release_date, description):
    update = Shows.objects.get(id=id)
    update.title = title
    update.network = network
    update.release_date = release_date
    update.description = description
    update.save()


def delete_a_show(id):
    Shows.objects.get(id=id).delete()


def get_a_show(id):
    return Shows.objects.get(id=id)


def get_all_show():
    return Shows.objects.all()
