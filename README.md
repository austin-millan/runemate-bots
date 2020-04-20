# runemate-bots

## About

This repo contains a collection of [RuneMate](https://www.runemate.com/) bots.

This development workspace is for IntelliJ IDEA workspaces specifically.

Note that RuneMate workspaces aren't configured to run your code directly.
They're configured to launch the dependency [`RuneMate.jar`](lib/RuneMate.jar) in development mode
which will then look for the bots in a specific directory on your computer. 

## Setup

### Ubuntu

#### Setup Java environment
```bash
# You'll need Java 1.8 (nothing higher):
sudo apt-get install openjdk-8-jre
# RuneMate bots use JavaFX:
sudo apt-get install openjfx
# Move the libraries:
sudo cp /usr/share/java/openjfx/jre/lib/ext/* /usr/lib/jvm/java-1.8.0-openjdk-amd64/lib
sudo cp /usr/share/java/openjfx/lib/* /usr/lib/jvm/java-1.8.0-openjdk-amd64/lib
sudo chmod 777 -R /usr/lib/jvm/java-1.8.0-openjdk-amd64
```

#### Configure IntelliJ IDE

- Navigate to File -> Project Structure -> Global Library
  - Add `/usr/share/java/openjfx` and `/usr/share/java/openjfx/lib`.
- Navigate to File -> Project Structure -> Libraries
  - Add `lib/RuneMate.jar`

I've provided a simple Run configuration in this template.
It's configured to launch the `RuneMate.jar` file with specific command-line arguments and RuneMate-specific classpath.
- Navigate to Run -> Edit Configuration -> Templates -> Application
  - "Main Class": com.runemate.boot.Boot
  - "Program Arguments": -sdk -login="runemateuser":"runematepassword"
  - "Use classpath of module": template

To save, click "Create configuration" at the top.

#### Configure RuneMate

Launch RuneMate by navigating to Run -> Run 'Boot, 
then go to the Settings page on RuneMate and update the path to this template project's path.
 
Once you have RuneMate launched, you'll need to ensure it can actually find the code in this repository.

#### Writing Bots

All bots should go under: [`src/com/<your_user>/bots/`](src/com/) to be picked up by RuneMate.

#### Setup OldSchool RuneScape:

```bash
mkdir -p '/tmp/oldschool'
wget -O '/tmp/oldschool/OldSchool.msi' 'http://www.runescape.com/downloads/oldschool.msi'
cd /tmp/oldschool && msiextract OldSchool.msi
cp /tmp/oldschool/jagexlauncher/jagexlauncher/bin/jagexappletviewer.jar /usr/local/bin/jagexappletviewer.jar
cp /tmp/oldschool/jagexlauncher/jagexlauncher/oldschool/jagexappletviewer.png /usr/local/share/jagexappletviewer.png
chmod 755 /usr/local/bin/jagexappletviewer.jar
rm -rf /tmp/oldschool
echo "/usr/local/bin/jre/bin/java -Duser.home=$HOME -Djava.class.path=/usr/local/bin/jagexappletviewer.jar -Dcom.jagex.config=http://oldschool.runescape.com/jav_config.ws jagexappletviewer /usr/local/share/" >> /usr/local/bin/oldschool
chmod +x /usr/local/bin/oldschool
```

### Windows

(TODO)

## Credits

The bots/code/resources from the following projects are included:
- [passive](https://github.com/PassiveModding/RuneMate])
- [Fabreze](https://github.com/KristofPusztai/Runemate-Bots)
- [Matsumotorise](https://github.com/Matsumotorise/Runemate-Scripts)
- [DerkSchooltink](https://github.com/DerkSchooltink/Varbit_varp) (varbit utilities)