from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    # path('admin/', myApp.urls),
    path('', include("myApp.urls")),
]
