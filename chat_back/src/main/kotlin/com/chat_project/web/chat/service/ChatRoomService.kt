package com.chat_project.web.chat.service

import com.chat_project.web.chat.dto.ChatRoomResponseDTO
import com.chat_project.web.chat.entity.ChatRoom
import com.chat_project.web.chat.repository.chatRoom.ChatRoomRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [ Exception::class ])
class ChatRoomService(
    private val chatRoomRepository: ChatRoomRepository,
    private val mapper: ModelMapper
) {
    @Transactional(readOnly = true)
    fun getChatRoomList(): MutableList<ChatRoomResponseDTO> {
        return chatRoomRepository.getChatRoomList()
    }

    fun addChatRoom(chatRoomDTO: ChatRoomResponseDTO): String {
        chatRoomRepository.save(mapper.map(chatRoomDTO, ChatRoom::class.java))
        return "success"
    }
}