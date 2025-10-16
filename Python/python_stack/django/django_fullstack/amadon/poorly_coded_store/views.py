from django.shortcuts import render,redirect
from .models import *

def index(request):
    context = {
        "all_products": get_all_products()
    }
    return render(request, "store/index.html", context)

def checkout(request,product_id):
    if 'order_id' in request.session:
        del request.session['order_id']
    quantity_from_form = int(request.POST["quantity"])
    product = get_product_by_id(product_id)
    total_charge = quantity_from_form * product.price
    order = create_order(quantity_from_form, total_charge)
    request.session['order_id'] = ''
    request.session["order_id"] = order.id
    return redirect(success)


def success(request):
    if not "order_id" in request.session:
        return redirect("/")
    order_id = request.session["order_id"]
    order = get_order_by_id(2)
    total_price = count_total_price(order_id)
    context = {
        "order": order[0],
        "total_price": total_price,
    }
    return render(request, "checkout.html",context)