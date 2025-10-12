from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('add_show', views.add_show),
    path('add_new_show', views.add_new_show),
    path('shows/<int:id>', views.display_show),
    path('show_edit/<int:id>', views.show_edit),
    path('edit', views.show_update),
    path('shows/<int:id>/delete', views.delete_show),
]
