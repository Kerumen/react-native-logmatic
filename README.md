# react-native-logmatic
Send your logs directly to [Logmatic](https://logmatic.io/) with React Native.

## Installation

```bash
$ npm install react-native-logmatic
$ react-native link react-native-logmatic
```

### Additional step for iOS

Install the Logmatic iOS SDK via Cocoapods:
 
```ruby
pod 'Logmatic'
```

## Usage

```js
import Logmatic from 'react-native-logmatic'

// init the logger using your APIKey
Logmatic.init(<apiKey>);

// [OPTIONAL] add extra fields for all events
Logmatic.setMetas({ extra: 'meta' });

// log your events (context is optional)
Logmatic.log('My first log');
Logmatic.log('My first log with context', { some: 'context' });

```
