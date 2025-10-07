from django.contrib import admin

from .models import Ninjas,Dojo

# Register your models here.

admin.site.register(Dojo)
admin.site.register(Ninjas)