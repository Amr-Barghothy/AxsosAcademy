from django.db import models
from django.db.models.aggregates import Count, Sum


class Product(models.Model):
    description = models.CharField(max_length=45)
    price = models.DecimalField(decimal_places=2, max_digits=5)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Order(models.Model):
    quantity_ordered = models.IntegerField()
    total_price = models.DecimalField(decimal_places=2, max_digits=6)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)



def create_order(quantity_ordered,total_price):
    return Order.objects.create(quantity_ordered=quantity_ordered, total_price=total_price)


def get_all_products():
    return Product.objects.all()

def get_order_by_id(order_id):
    return Order.objects.filter(id=order_id)

def get_product_by_id(product_id):
    return Product.objects.get(id=product_id)

def count_total_price():
    return Order.objects.annotate(sum_price=Sum('total_price')).order_by('sum_price')

def count_items():
    return Order.objects.annotate(count=Count('quantity_ordered')).order_by('count')