package com.ceiba.users_presentation.list

sealed class UserEvent {
    object onGetUsers : UserEvent()
    data class OnClickPostByUser(val id: Int) : UserEvent()
    data class OnQueryChange(val query: String) : UserEvent()
    object OnSearch : UserEvent()
    data class OnSearchFocusChange(val isFocused: Boolean) : UserEvent()
}