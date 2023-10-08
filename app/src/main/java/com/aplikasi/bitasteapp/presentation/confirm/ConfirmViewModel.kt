//package com.aplikasi.bitasteapp.presentation.confirm
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.aplikasi.bitasteapp.repository.FoodRepository
//import kotlinx.coroutines.launch
//
//class ConfirmViewModel(private val foodRepository: FoodRepository) : ViewModel() {
//    // TODO: Implement the ViewModel
//    private val _food = MutableLiveData<List<FoodEntity>>()
//    val food: LiveData<List<FoodEntity>> get() = _food
//
//    fun getAllFood() = viewModelScope.launch {
//        _food.postValue(foodRepository.getAllFoodCart())
//    }
//
//    fun deleteFood(foodEntity: FoodEntity) = viewModelScope.launch {
//        foodRepository.removeFood(foodEntity)
//    }
//
//    fun deleteALl() = viewModelScope.launch {
//        foodRepository.deleteAll()
//    }
//}