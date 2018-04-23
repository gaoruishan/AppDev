
1,Android Butterknife 8.4.0 使用方法总结
  https://www.cnblogs.com/zhaoyanjun/p/6016341.html

  (1)控件id 注解： @BindView（）
     @BindView(R.id.button1)
     public Button button1 ;
     注:修饰类型不能是：private 或者 static

  (2)多个控件id 注解： @BindViews（）
     @BindViews({ R.id.button1,R.id.button2,R.id.button3 })
     public List<Button> buttonList ;

  (3)@BindString() ：绑定string 字符串
     @BindString(R.string.app_name)
     String meg;

  (4)@BindArray() : 绑定string里面array数组
     @BindArray(R.array.city)
     String [] citys ;

  (5)@BindBitmap( ) : 绑定Bitmap 资源
     @BindBitmap(R.mipmap.wifi)
     public Bitmap wifi_bitmap ;

  (6)@BindColor( ) : 绑定一个颜色值
    @BindColor(R.color.colorAccent)
    int black ;

  (7)@OnClick( ) : 绑定控件点击事件
  (8)@OnLongClick( ) ： 绑定控件长按事件