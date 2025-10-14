from django.db import models


# Create your models here.

class Description(models.Model):
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


class CourseManager(models.Manager):
    def validate_course(self, post_data):
        errors = {}
        if post_data['name'] == "":
            errors['name'] = "Name is required"
        if post_data['description'] == "":
            errors['description'] = "Description is required"
        if post_data['name'] != "" and len(post_data['name']) < 5:
            errors['name_len'] = "Name should be more than 5 characters"
        if post_data['description'] != "" and len(post_data['description']) < 15:
            errors['description_len'] = "Description should be more than 15 characters"

        return errors


class Course(models.Model):
    name = models.CharField(max_length=255)
    description = models.OneToOneField(Description, related_name="courses", on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = CourseManager()


def create_a_course(name, description):
    return Course.objects.create(name=name, description=description)

def create_a_description(description):
    return Description.objects.create(description=description)

def delete_a_course(course_id):
    return Course.objects.get(id=course_id).delete()

def get_all_courses():
    return Course.objects.all()

def get_a_course(course_id):
    return Course.objects.get(id=course_id)