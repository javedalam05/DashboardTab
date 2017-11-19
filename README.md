# DashboardTab

![alt text](https://github.com/javedalam05/DashboardTab/blob/master/in_tab2.png)

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


##	How to use TabView:

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
This is for height ratio. (4 = screenheight/4 means one fourth part of the device screen height). You also pass value in float like 3.5 or 4.5 that means screenheight/3.5 or screenheight/4.5.

```
vi.	app:tag="2"
```
This is for row tag (2 = row 2, 1 = row 1). Change tags according to need



## Interface button clicks:
•	Left tab of a row always be in odd series like as given in toast (Refer:firstButtonClick)

•	Right tab of a row always be in even service like as given in toast (Refer: secondButtonClick)


i.	firstButtonClick for left tab click (Differentiate by tags you given in xml)
```
@Override
public void firstButtonClick(inttag) {
switch (tag) {
case 1:
Toast.makeText(this, "click tab 1", Toast.LENGTH_SHORT).show();
break;
case 2:
Toast.makeText(this, "click tab 3", Toast.LENGTH_SHORT).show();
break;

        }

    }
```

```
ii.	secondButtonClick for right tab click (Differentiate by tags you given in xml)

@Override
public void secondButtonClick(inttag) {
switch (tag) {
case 1:
Toast.makeText(this, "click tab 2", Toast.LENGTH_SHORT).show();
break;
case 2:
Toast.makeText(this, "click tab 4", Toast.LENGTH_SHORT).show();
break;

        }
    }

```
