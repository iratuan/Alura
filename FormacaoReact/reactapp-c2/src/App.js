import React, { Component } from 'react';
import Header from './components/Header';
import Timeline from './components/Timeline';
import "./css/login.css";
import "./css/reset.css";
import "./css/timeline.css";

class App extends Component {
  render() {
    return (
    <div id="root">
      <div className="main">
        <Header/>
        <Timeline/>
      </div>
    </div>
    );
  }
}

export default App;
