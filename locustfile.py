from locust import HttpUser, task, between
import random

class BaykarWebsite(HttpUser):
    host = "https://kariyer.baykartech.com/en/"
    wait_time = between(5, 15)

    @task(5)
    def view_homepage(self):
        self.client.get("https://kariyer.baykartech.com/en/")

    @task(4)
    def view_open_positions(self):
        self.client.get("https://kariyer.baykartech.com/en/application/open-positions/")

    @task(3)
    def view_login_page(self):
        self.client.get("https://kariyer.baykartech.com/en/hesaplar/login/?next=/en/dashboard/")

    @task(3)
    def view_sign_up_page(self):
        self.client.get("https://kariyer.baykartech.com/en/hesaplar/signup/")

    @task(2)
    def login(self):
        usernames = ["asd@gmail.com","sdada@dsda.com","cfsd@dasa.com"]
        passwords = ["password123","123Password","Pas123word"]
        username = random.choice(usernames)
        password = random.choice(passwords)
        response = self.client.post("https://kariyer.baykartech.com/en/hesaplar/login/?next=/en/dashboard/", json={"email": username, "password": password})
        if response.status_code == 200:
            self.locust.success()
        else:
            self.locust.failure("Login failed")

    @task(2)
    def sign_up(self):
        email = "testmail" + str(random.randint(1, 99)) + "@test.com"
        password = "password123"
        response = self.client.post("https://kariyer.baykartech.com/en/hesaplar/signup/", json={"email": email, "password": password})
        if response.status_code == 200:
            self.locust.success()
        else:
            self.locust.failure("Sign up failed")