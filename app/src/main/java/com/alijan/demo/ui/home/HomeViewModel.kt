package com.alijan.demo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private var _city = MutableLiveData<List<String>>()
    val city: LiveData<List<String>> get() = _city

    private val cities = arrayListOf<String>(
        "Adana", "Adiyaman", "Afyonkarahisar", "Agri", "Aksaray",
        "Amasya", "Ankara", "Antalya", "Ardahan", "Artvin",
        "Aydin", "Balikesir", "Bartin", "Batman", "Bayburt",
        "Bilecik", "Bingol", "Bitlis", "Bolu", "Burdur",
        "Bursa", "Canakkale", "Cankiri", "Corum", "Denizli",
        "Diyarbakir", "Duzce", "Edirne", "Elazig", "Erzincan",
        "Erzurum", "Eskisehir", "Gaziantep", "Giresun", "Gumushane",
        "Hakkari", "Hatay", "Igdir", "Isparta", "Istanbul",
        "Izmir", "Kahramanmaras", "Karabuk", "Karaman", "Kars",
        "Kastamonu", "Kayseri", "Kilis", "Kirikkale", "Kirklareli",
        "Kirsehir", "Kocaeli", "Konya", "Kutahya", "Malatya",
        "Manisa", "Mardin", "Mersin", "Mugla", "Mus",
        "Nevsehir", "Nigde", "Ordu", "Osmaniye", "Rize",
        "Sakarya", "Samsun", "Siirt", "Sinop", "Sirnak",
        "Sivas", "Tekirdag", "Tokat", "Trabzon", "Tunceli",
        "Usak", "Van", "Yalova", "Yozgat", "Zonguldak"
    )

    init {
        getAllCity()
    }

    private fun getAllCity() {
        _city.value = cities
    }

}