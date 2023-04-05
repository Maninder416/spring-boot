import Head from 'next/head'
import Image from 'next/image'
import { Inter } from 'next/font/google'
import styles from '@/styles/Home.module.css'

const Home: NextPage = () => {
    return (
       <div>
        <nav class="navbar bg-dark" data-bs-theme="dark">
          <div class="container-fluid">
            <a class="navbar bg-dark" href="#">Bookmarker</a>
            <a class="navbar bg-dark" aria-current="page" href="#">Add Bookmark</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            </div>
          </div>
        </nav>



       </div>
    )
}

export default Home
