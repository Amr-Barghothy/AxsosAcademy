from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('destroy_session', views.del_session),
    path('inc_by_two', views.inc_by_two),
    path('custom_inc', views.custom_inc),
]