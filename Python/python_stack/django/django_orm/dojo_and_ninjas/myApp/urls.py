from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('add_dojo', views.add_dojo),
    path('add_ninjas', views.add_ninjas),
    path('delete', views.delete_a_dojo),

]
