package com.clone.finalProject.service;

import com.clone.finalProject.domain.ChatMessage;
import com.clone.finalProject.domain.ChatRoom;
import com.clone.finalProject.dto.ChatMessageDto;
import com.clone.finalProject.dto.ChatMessagedResponseDto;
//import com.clone.finalProject.dto.ChatRoomDto;
import com.clone.finalProject.repository.ChatMessageRepository;
import com.clone.finalProject.repository.ChatRoomRepository;
import com.clone.finalProject.repository.RedisChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final RedisChatRepository redisChatRepository;

    public String getRoomId(String destination) {
        int lastIndex = destination.lastIndexOf('/');
        if (lastIndex != -1)
            return destination.substring(lastIndex + 1);
        else
            return "";
    }

    // 메인페이지 채널 채팅 내역 조회
    public List<ChatMessagedResponseDto> chatMainGet() {

        List<ChatMessage> chatMessageList = chatMessageRepository.findTOP50ByChatRoom_AreaOrderByCreatedAtDesc("main");

        List<ChatMessagedResponseDto> chatMessagedResponseDtoList = new ArrayList<>();
        for(ChatMessage chatMessage : chatMessageList) {
            ChatMessagedResponseDto chatMessagedResponseDto = new ChatMessagedResponseDto(chatMessage);

            chatMessagedResponseDtoList.add(chatMessagedResponseDto);

        }

        return chatMessagedResponseDtoList;

    }

    // 게시글 페이지 채널 채팅 내역 조회
    public List<ChatMessagedResponseDto> chatMainPost(Long pid) {

        List<ChatMessage> chatMessageList = chatMessageRepository.findTOP50ByChatRoom_PidOrderByCreatedAtDesc(pid);

        List<ChatMessagedResponseDto> chatMessagedResponseDtoList = new ArrayList<>();
        for(ChatMessage chatMessage : chatMessageList) {
            ChatMessagedResponseDto chatMessagedResponseDto = new ChatMessagedResponseDto(chatMessage);

            chatMessagedResponseDtoList.add(chatMessagedResponseDto);

        }

        return chatMessagedResponseDtoList;

    }

    // 귓속말 채널 채팅 내역 조회
    public List<ChatMessagedResponseDto> chatMainUser(Long uid) {

        List<ChatMessage> chatMessageList = chatMessageRepository.findTOP50ByChatRoom_UidOrderByCreatedAtDesc(uid);

        List<ChatMessagedResponseDto> chatMessagedResponseDtoList = new ArrayList<>();
        for(ChatMessage chatMessage : chatMessageList) {
            ChatMessagedResponseDto chatMessagedResponseDto = new ChatMessagedResponseDto(chatMessage);

            chatMessagedResponseDtoList.add(chatMessagedResponseDto);

        }

        return chatMessagedResponseDtoList;

    }
}
