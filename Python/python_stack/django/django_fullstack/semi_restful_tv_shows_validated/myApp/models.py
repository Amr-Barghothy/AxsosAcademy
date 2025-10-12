from django.db import models
from django.utils import timezone


# Create your models here.

class ShowsManager(models.Manager):
    def validate_show(self, post_data):
        if not post_data:
            return False
        errors = {}
        current_date = timezone.now().date()
        if Shows.objects.filter(title=post_data['title']).exists():
            errors['title_rep'] = "This title is already in use."
        if len(post_data['title']) == 0:
            errors['title_req'] = 'title is required'
        if len(post_data['network']) == 0:
            errors['network_req'] = 'network is required'
        if len(post_data['release_date']) == 0:
            errors['release_date_req'] = 'release date is required'
        if len(post_data['title']) < 2 and post_data['title'] != '':
            errors['title'] = 'title should be more than or equal to 2 characters'
        if len(post_data['network']) < 3 and post_data['network'] != '':
            errors['network'] = 'network should be more than or equal to 3 characters'
        if post_data['desc'] != '':
            if len(post_data['desc']) < 10:
                errors['description'] = 'description should be more than or equal to 10 characters'
        if post_data['release_date'] >= str(current_date):
            errors['release_date_past'] = 'release date should be in the past'
        return errors


class Shows(models.Model):
    title = models.CharField(max_length=100)
    network = models.CharField(max_length=100)
    release_date = models.DateField()
    description = models.TextField(null=True, blank=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowsManager()


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
