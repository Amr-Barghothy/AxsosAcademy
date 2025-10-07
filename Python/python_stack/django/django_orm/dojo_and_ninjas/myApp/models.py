from django.db import models

# Create your models here.

class Dojo(models.Model):
    name = models.CharField(max_length=255)
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Ninjas(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    dojo_id = models.ForeignKey(Dojo,related_name = "ninjas",on_delete=models.CASCADE)
    updated_at = models.DateTimeField(auto_now=True)
    created_at = models.DateTimeField(auto_now_add=True)


def create_dojo(name,city,state):
    return Dojo.objects.create(name=name,city=city,state=state)

def create_ninjas(first_name,last_name,dojo_id):
    return Ninjas.objects.create(first_name=first_name,last_name=last_name,dojo_id=dojo_id)

def get_dojo(dojo_id):
    return Dojo.objects.get(id=dojo_id)

def get_ninjas(ninja_id):
    return Ninjas.objects.get(id=ninja_id)

def get_all_dojos():
    return Dojo.objects.all()

def get_all_ninjas():
    return Ninjas.objects.all()

def delete_dojo(dojo_id):
    return Dojo.objects.get(id=dojo_id).delete()

def delete_ninjas(ninja_id):
    return Ninjas.objects.get(id=ninja_id).delete()
