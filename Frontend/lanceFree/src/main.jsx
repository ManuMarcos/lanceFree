import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { Navbar } from './components/navbar/Navbar.jsx'
import { Main } from './components/main/Main.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Navbar></Navbar>
    <Main></Main>
  </React.StrictMode>
)
