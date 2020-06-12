IO: 面向流   阻塞IO                         
    单向的: 输入流,输出流, 数据流动是单向的            
                                                      
                                                 
                                                 
                                                 
                                                 
  NIO: 面向缓冲区 非阻塞IO 选择器 
  双向的: 缓存区可以双向传输的  
  通道: 一条很宽的柏油马路,将人群用车从一个地方拿到另一个地方,还可以拉回来   
  通道(Channel)->负责连接,负责传输   车->就是缓冲区(Buffer),负责存储
  
  缓冲区 Buffer:负责数据存储,就是数组,用于存储不同类型的数据根据数据类型不同,提供相同类型的缓冲区
  - ByteBuffer：字节缓冲区（最常用的）
  - CharBuffer
  - ShortBuffer
  - IntBuffer
  - LongBuffer
  - FloatBuffer
  - DoubleBuffer
  缓冲区中的方法:  上面缓冲区的管理方式几乎一致， 通过 allocate() 获取缓冲区
  - put()：存入数据到缓冲区中
  - get()：获取缓冲区中的数据
  - hasRemaining()：判断缓冲区是否还有剩余的数据
  - remaining()：获取缓冲区还有多少剩余数据
  - mark()：标记postion的位置
  - reset()：恢复到刚标记的地方
  缓冲区核心属性:
  - capacity：容量，表示缓冲区中最大存储数据的容量，一旦申明不可改变。
  - limit：界限，表示缓冲区中的可以操作数据的大小。（limit 后数据不能进行读写）
  - position：位置，表示缓冲区中正在操作的位置
  - mark：标记，表示记录当前 position 的位置，可以通过reset() 恢复到 mark的位置
  最后它们之间的关系是：0 <= mark <= position <= limit <= capacity                                                