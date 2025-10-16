from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('checkout/<product_id>', views.checkout),
    path('success', views.success),
]
