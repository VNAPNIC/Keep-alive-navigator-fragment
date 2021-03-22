# Keep-alive-navigator-fragment
Keep alive navigator fragment


### The library Don't support databiding


```
implementation 'com.vnapnic.keepalive:navigator:1.0.0'
```

activity_main.xml

```xml
        <com.vnapnic.keepalivenavigator.KeepAliveNavigationHost
            android:id="@+id/nav_host_fragment"
            android:name="androidx.navigation.fragment.NavHostFragment"
            android:layout_width="0dp"
            android:layout_height="0dp"
            app:defaultNavHost="true"
            app:layout_constraintBottom_toTopOf="@+id/bottom_nav"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:navGraph="@navigation/nav_graph" />
```

nav_graph.xml

```xml
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/navigation"
    app:startDestination="@id/navMyFragment">

    <keep_alive_fragment
        android:id="@+id/navMyFragment"
        android:name="ui.MyFragment"
        android:label="NewsFeed"
        tools:layout="@layout/fragment_test" />
   ...

</navigation>
```
