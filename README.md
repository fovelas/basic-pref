### Prerequisites

Add this maven line to root `settings.gradle`

~~~
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
~~~

-----------------------------------------

### Dependency

Lastly add this line to `build.gradle` file in app module.

~~~
dependencies {
    implementation 'com.github.fovelas:basic-pref:1.0.1'
}
~~~

-----------------------------------------

### Set Data

```java
BasicPref basicPref = BasicPref.getInstance(MainActivity.this);

basicPref.setBoolean("example_key", false);
basicPref.setFloat("example_key", 0.5);
basicPref.setInt("example_key", 120);
basicPref.getLong("example_key", 1.78954);
basicPref.setString("example_key", "this is value");

// also you can use like that
BasicPref.getInstance(MainActivity.this).setString("example_key", "this is value");
```

-----------------------------------------

### Get Data

If your key not found (not sett) default value will be return.

```java
BasicPref basicPref = BasicPref.getInstance(MainActivity.this);

basicPref.getBoolean("example_key", false);
basicPref.getFloat("example_key", 1);
basicPref.getInt("example_key", 0);
basicPref.getLong("example_key", 0);
basicPref.getString("example_key", "default value");

// also you can use like that
BasicPref.getInstance(MainActivity.this).getString("example_key", "this is default value");
```

-----------------------------------------

### Remove Data

Removes given key value.

```java
BasicPref basicPref = BasicPref.getInstance(MainActivity.this);

basicPref.remove("example_key");

// also you can use like that
BasicPref.getInstance(MainActivity.this).remove("example_key");
```

-----------------------------------------

### Clear Data

Removes all data.

```java
BasicPref basicPref = BasicPref.getInstance(MainActivity.this);

basicPref.clear();

// also you can use like that
BasicPref.getInstance(MainActivity.this).clear();
```