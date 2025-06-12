"use client"
import { useState } from 'react';
import Image from 'next/image';
import Link from 'next/link';


// Giả lập dữ liệu tin nhắn
const mockConversations = [
  { id: 1, user: 'John Doe', lastMessage: 'Hey, ?Hey, ?Hey, ?Hey, ?Hey, ?Hey, ?Hey, ?Hey, ?Hey, ?Hey, ?', time: '10:30 AM' },
  { id: 2, user: 'Jane Smith', lastMessage: 'Can we meet tomorrow?', time: 'Yesterday' },
  { id: 3, user: 'Alice Johnson', lastMessage: 'Check thitruncatetruncatetruncatetruncatetruncatetruncatetruncatetruncatetruncatetruncates out!', time: '2 days ago' },
  { id: 4, user: 'Bob Wilson', lastMessage: 'Lunch plans?', time: '3 days ago' },
  { id: 5, user: 'Emma Brown', lastMessage: 'See you soon!', time: '4 days ago' },

];

const mockMessages = [
  { id: 1, sender: 'John Doe', content: 'Hey, how are you?', time: '10:30 AM' },
  { id: 2, sender: 'You', content: 'Doing great, thanks!', time: '10:32 AM' },
  { id: 3, sender: 'John Doe', content: 'Wanna grab coffee later?', time: '10:35 AM' },
  { id: 4, sender: 'You', content: 'Sure, what time?', time: '10:36 AM' },
  { id: 5, sender: 'John Doe', content: 'How about 3 PM?', time: '10:37 AM' },
];

export default function Message() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [selectedConversation, setSelectedConversation] = useState(null);

  return (
    <div className="min-h-screen bg-gray-100 flex flex-col">
      {/* Header */}
      <header className="bg-blue-600 text-white p-4 flex justify-between items-center">
        {/* Logo */}
        <div className="flex items-center">
          <Image src="/logo.png" alt="Logo" width={40} height={40} />
          <span className="ml-2 text-xl font-bold">ChatApp</span>
        </div>

        {/* Navigation */}
        <nav className="flex space-x-4">
          <Link href="/" className="hover:underline">Trang chủ</Link>
          <Link href="/search" className="hover:underline">Tìm kiếm</Link>
          <Link href="/friends" className="hover:underline">Bạn bè</Link>
        </nav>

        {/* Login Icon */}
        <div>
          {isLoggedIn ? (
            <button onClick={() => setIsLoggedIn(false)} className="flex items-center space-x-2">
              <Image src="/user.png" alt="User" width={30} height={30} className="rounded-full" />
              <span>Đăng xuất</span>
            </button>
          ) : (
            <button onClick={() => setIsLoggedIn(true)} className="flex items-center space-x-2">
              <Image src="/login.png" alt="Login" width={30} height={30} />
              <span>Đăng nhập</span>
            </button>
          )}
        </div>
      </header>

      {/* Main Content */}
      <main className="flex flex-1 overflow-hidden">
        {/* Aside: Conversation List */}
        <aside className="w-1/3 bg-white border-r border-gray-200 h-[calc(100vh-64px)] flex flex-col">
          <div className="p-4">
            <h2 className="text-lg font-semibold">Tin nhắn</h2>
          </div>
          <div className="flex-1 overflow-y-auto px-4 pb-4">
            <ul>
              {mockConversations.map((conv) => (
                <li
                  key={conv.id}
                  className={`p-3 mb-2 rounded-lg cursor-pointer hover:bg-gray-100 ${
                    selectedConversation === conv.id ? 'bg-blue-100' : ''
                  }`}
                  onClick={() => setSelectedConversation(conv.id)}
                >
                  <div className="flex justify-between">
                    <div className="flex-1 min-w-0 pr-2">
                      <p className="font-semibold">{conv.user}</p>
                      <p className="text-sm text-gray-600 truncate">{conv.lastMessage}</p>
                    </div>
                    <p className="text-sm text-gray-500">{conv.time}</p>
                  </div>
                </li>
              ))}
            </ul>
          </div>
        </aside>

        {/* Main Chat Area */}
        <section className="flex-1 bg-gray-50 p-4 flex flex-col h-[calc(100vh-64px)]">
          {selectedConversation ? (
            <>
              <h2 className="text-lg font-semibold mb-4">
                {mockConversations.find((conv) => conv.id === selectedConversation)?.user}
              </h2>
              <div className="flex-1 overflow-y-auto mb-4">
                {mockMessages.map((msg) => (
                  <div
                    key={msg.id}
                    className={`mb-4 flex ${
                      msg.sender === 'You' ? 'justify-end' : 'justify-start'
                    }`}
                  >
                    <div
                      className={`p-3 rounded-lg max-w-xs ${
                        msg.sender === 'You' ? 'bg-blue-500 text-white' : 'bg-gray-200'
                      }`}
                    >
                      <p>{msg.content}</p>
                      <p className="text-xs text-gray-400">{msg.time}</p>
                    </div>
                  </div>
                ))}
              </div>
              <div className="flex">
                <input
                  type="text"
                  placeholder="Nhập tin nhắn..."
                  className="flex-1 p-2 border rounded-l-lg focus:outline-none"
                />
                <button className="bg-blue-600 text-white p-2 rounded-r-lg">Gửi</button>
              </div>
            </>
          ) : (
            <div className="flex-1 flex items-center justify-center">
              <p className="text-gray-500">Chọn một cuộc trò chuyện để bắt đầu</p>
            </div>
          )}
        </section>
      </main>
    </div>
  );
}