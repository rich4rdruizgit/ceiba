package com.ceiba.users_presentation.list

sealed class UserEvent{
    object onGetUsers: UserEvent()
}