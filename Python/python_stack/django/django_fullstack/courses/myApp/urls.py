from django.urls import path
from . import views
urlpatterns = [
    path('',views.index),
    path('add_course',views.add_course),
    path('destroy/<course_id>',views.destroy),
    path('delete/<course_id>',views.delete),
]