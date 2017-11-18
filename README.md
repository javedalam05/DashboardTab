# DashboardTab

Create a simple dashboard tabs using Custom TabView.

```
<com.custom.views.TabView
android:id="@+id/tab_view_2"
android:layout_width="match_parent"
android:layout_height="wrap_content"
app:drawable_one="@drawable/icon_img"
app:drawable_two="@drawable/icon_camera"
app:tab_height="4"
app:tag="2"
app:text_1="Text 1"
app:text_2="Text 2" />
```


###	Here the explanation regarding TabView:

```
i.	app:drawable_one="@drawable/icon_img"
```
This is left drawable for row

```
ii.	app:drawable_two="@drawable/icon_camera"
```
This is rightdrawable for row

```
iii.	app:text_1="Text 1"
```
This is left text for row

```
iv.	app:text_2="Text 2"
```
This is right text for row

```
v.	app:tab_height="4"
```
This is for height ratio. (4= 40% of device screen height)

```
vi.	app:tag="2"
```
This is for row tag (2 = row 2, 1 = row 1). Change tags according to need
